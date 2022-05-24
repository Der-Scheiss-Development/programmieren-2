import java.util.*;

enum Symbol {
  SEVEN("7"),
  EIGHT("8"),
  NINE ("9"),
  TEN  ("10"),
  JACK ("J"),
  QUEEN("Q"),
  KING ("K"),
  ACE  ("A");

  String symbol;

  Symbol(String symbol) { //constructor
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }
}

enum Color {
  CLUB   ("♧"), //nice UTF-8 symbols
  SPADE  ("♤"),
  HEART  ("♡"),
  DIAMOND("♢");

  String color;

  Color(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}

enum Card {
  KREUZ_SIEBEN(Color.CLUB   , Symbol.SEVEN),
  KREUZ_ACHT  (Color.CLUB   , Symbol.EIGHT),
  KREUZ_NEUN  (Color.CLUB   , Symbol.NINE ),
  KREUZ_ZEHN  (Color.CLUB   , Symbol.TEN  ),
  KREUZ_BUBE  (Color.CLUB   , Symbol.JACK ),
  KREUZ_DAME  (Color.CLUB   , Symbol.QUEEN),
  KREUZ_KOENIG(Color.CLUB   , Symbol.KING ),
  KREUZ_ASS   (Color.CLUB   , Symbol.ACE  ),
  PIK_SIEBEN  (Color.SPADE  , Symbol.SEVEN),
  PIK_ACHT    (Color.SPADE  , Symbol.EIGHT),
  PIK_NEUN    (Color.SPADE  , Symbol.NINE ),
  PIK_ZEHN    (Color.SPADE  , Symbol.TEN  ),
  PIK_BUBE    (Color.SPADE  , Symbol.JACK ),
  PIK_DAME    (Color.SPADE  , Symbol.QUEEN),
  PIK_KOENIG  (Color.SPADE  , Symbol.KING ),
  PIK_ASS     (Color.SPADE  , Symbol.ACE  ),
  HERZ_SIEBEN (Color.HEART  , Symbol.SEVEN),
  HERZ_ACHT   (Color.HEART  , Symbol.EIGHT),
  HERZ_NEUN   (Color.HEART  , Symbol.NINE ),
  HERZ_ZEHN   (Color.HEART  , Symbol.TEN  ),
  HERZ_BUBE   (Color.HEART  , Symbol.JACK ),
  HERZ_DAME   (Color.HEART  , Symbol.QUEEN),
  HERZ_KOENIG (Color.HEART  , Symbol.KING ),
  HERZ_ASS    (Color.HEART  , Symbol.ACE  ),
  KARO_SIEBEN (Color.DIAMOND, Symbol.SEVEN),
  KARO_ACHT   (Color.DIAMOND, Symbol.EIGHT),
  KARO_NEUN   (Color.DIAMOND, Symbol.NINE ),
  KARO_ZEHN   (Color.DIAMOND, Symbol.TEN  ),
  KARO_BUBE   (Color.DIAMOND, Symbol.JACK ),
  KARO_DAME   (Color.DIAMOND, Symbol.QUEEN),
  KARO_KOENIG (Color.DIAMOND, Symbol.KING ),
  KARO_ASS    (Color.DIAMOND, Symbol.ACE  );

  final Color  color;
  final Symbol symbol;

  Card(Color color, Symbol symbol) { //little bit of structure etc
    this.color = color;
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return color + "" + symbol;
  }
}

record Move(Card card, Color color) {}

interface MauMauable {
  void putOnTop(Card c);
  public int getPenalty();
  boolean isAllowed(Card c);
  void apply(Move m);
  Card top();
}

class MauMau implements MauMauable {
  Card top;

  @Override
  public void putOnTop(Card c) {
    top = c;
  }

  @Override
  public int getPenalty() {
    return 1;
  }

  @Override
  public boolean isAllowed(Card c) {
    if(top.symbol == c.symbol || top.color == c.color) {
      return true;
    }
    return false;
  }

  @Override
  public void apply(Move m) {
    if( !isAllowed(m.card()) ) {
      throw new RuntimeException("Player unallowed card, nothing is done.");
    }
    putOnTop(m.card());
    //System.out.println("played: " + m.card());
  }

  @Override
  public Card top() {
    return top;
  }

  @Override
  public String toString() {
    StringBuilder statusLine = new StringBuilder();
    statusLine.append("# top-card: " + top);
    return statusLine.toString();
  }

}

class MauMauExt extends MauMau {
  private enum State {
    NORMAL,
    DRAW,
    WISH,
    SKIP,
  }

  State state;
  Color wished_color;
  int num_draw;

  MauMauExt() {
    state = State.NORMAL;
    wished_color = null;
    num_draw = 0;
  }

  @Override
  public int getPenalty() {
    int draws = switch( state ) {
      case NORMAL, WISH -> 1;
      case DRAW -> num_draw;
      default -> 0; // in case of SKIP
    };
    num_draw = 0;
    if( state != State.WISH ) {
      state = State.NORMAL;
    }
    return draws;
  }

  @Override
  public boolean isAllowed(Card c) {
    switch( state ) {
      case NORMAL -> {
        if( super.isAllowed(c) || c.symbol == Symbol.JACK ) {
          return true;
        }
      }
      case WISH -> {
        if( c.color == wished_color  && c.symbol != Symbol.JACK ) {
          return true;
        }
      }
      case DRAW -> {
        if( c.symbol == Symbol.SEVEN ) {
          return true;
        }
      }
      case SKIP -> {
        if( c.symbol == Symbol.ACE ) {
          return true;
        }
      }
      default -> throw new RuntimeException("No such state");
    }
    return false;
  }

  @Override
  public void apply(Move m) {
    super.apply(m);
    Card c = m.card();
    if( state == State.WISH ) {
      assert c.symbol != Symbol.JACK;
      state = State.NORMAL;
      wished_color = null;
    }
    switch( c.symbol ) {
      case JACK -> {
        wished_color = m.color();
        state = State.WISH;
      }
      case SEVEN -> {
        state = State.DRAW;
        num_draw += 2;
      }
      case ACE -> {
        state = State.SKIP;
      }
      default -> {
        assert state == State.NORMAL;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder statusLine = new StringBuilder(super.toString());
    statusLine.append(" state: " + state);
    statusLine.append("(draws=" + num_draw + ", wish=" + wished_color + ")");
    return statusLine.toString();
  }
}

class Game {
  MauMauable state;
  LinkedList<Card> talon;
  Player[] players;
  Player winner;

  Game(Player[] players, MauMauable state) {
    this.players = players;
    talon = new LinkedList<Card>(Arrays.asList(Card.values()));
    Collections.shuffle(talon);

    int cards_per_player = 5;
    this.state = state;
    state.putOnTop(talon.pop());
    for( Player p : players ) {
      p.setHand(talon.subList(0, 5).toArray(new Card[0]));
      talon.subList(0, 5).clear();
    }
    winner = null;
  }

  void start() {
    //System.out.println("New game starts:");
    while( winner == null ) {
      for( Player p : players ) {
        //System.out.println(p.getName() + " make your choice: ");
        Move m = p.ask(state);
        if( m.card() == null ) {
          int draws = state.getPenalty();
          //System.out.println(p.getName() + " draws " + draws);
          for(int i = 0; i < draws; ++i) {
            if( !talon.isEmpty() ) {
              p.add(talon.pop());
            }
          }
          continue;
        }
        if( p.remove(m.card()) == 0 ) {
          winner = p;
          return;
        }
        talon.push(state.top());
        Collections.shuffle(talon);
        state.apply(m);
      }
    }
  }
}

class Player {
  String name;
  LinkedList<Card> hand;
  Player(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  void setHand(Card... crds) {
    hand = new LinkedList<Card>(Arrays.asList(crds));
    Collections.sort(hand);
  }

  public String toString() {
    return name + ": " + hand;
  }

  Move ask(MauMauable state) {
    int card_num;
    do {
      //System.out.println(state);
      //System.out.println("you have the cards: " + hand);
      //System.out.println("make your choice: 0.." + (hand.size() - 1) + " (-1 for draw): ");
      Scanner in = new Scanner(System.in);
      card_num = in.nextInt();
      if( card_num <= -1 || card_num >= hand.size() ) {
        return new Move(null, null);
      }
    } while( !state.isAllowed(hand.get(card_num)) );
    Card c = hand.get(card_num);
    return new Move(c, c.symbol == Symbol.JACK ? chooseColor() : null);
  }

  int remove(Card c) {
    hand.remove(c);
    return hand.size();
  }

  void add(Card c) {
    hand.push(c);
    Collections.sort(hand);
  }

  Color chooseColor() {
    int color_num;
    do {
      //System.out.println("choose a color: 0.." + (Color.values().length - 1) + " -> ♧, ♤, ♡, ♢ : ");
      Scanner in = new Scanner(System.in);
      color_num = in.nextInt();
    } while( color_num < 0 || color_num >= Color.values().length );
    return Color.values()[color_num];
  }
}

class ComputerPlayer extends Player {
  Random rng;

  ComputerPlayer(String name) {
    super(name);
    rng = new Random();
  }

  @Override
  Move ask(MauMauable state) {
    //System.out.println(state);
    //System.out.println("you have the cards: " + hand);
    Card proposal = null;
    for( Card c : hand ) {
      if( state.isAllowed(c) ) {
        proposal = c;
        break;
      }
    }
    if( proposal != null && proposal.symbol == Symbol.JACK ) {
      return new Move(proposal, chooseColor());
    }
    return new Move(proposal, null);
  }

  @Override
  Color chooseColor() {
    return Color.values()[rng.nextInt(Color.values().length)];
  }
}

class ComputerPlayerBetter extends ComputerPlayer {
  ComputerPlayerBetter(String name) {
    super(name);
  }

  Card playableSevens(MauMauable state) {
    int num_sevens = 0;
    boolean playable_seven = false;
    for( Card c : hand ) {
      if( c.symbol == Symbol.SEVEN ) {
        num_sevens = +1;
      }
    }
    for( Card c : hand ) {
      if( c.symbol == Symbol.SEVEN && state.isAllowed(c) ) {
        playable_seven = true;
        if( num_sevens > 1 ) {
          return c;
        }
      }
    }
    return null;
  }

  Card bestPlayableCard(MauMauable state) {
    // A custom comparator to sort playable cards with priority
    Comparator<Card> cardSymbolComparator = new Comparator<Card>() {
      @Override
      public int compare(final Card c1, final Card c2) {
        EnumSet<Symbol> SA = EnumSet.of(Symbol.SEVEN, Symbol.ACE);
        EnumSet<Symbol> SJA = EnumSet.of(Symbol.SEVEN, Symbol.JACK, Symbol.ACE);
        boolean c1_is_special = SJA.contains(c1.symbol);
        boolean c2_is_special = SJA.contains(c2.symbol);
        boolean c1_is_SorA = SA.contains(c1.symbol);
        boolean c2_is_SorA = SA.contains(c2.symbol);
        if( c1.symbol == c2.symbol ||
                c1_is_SorA && c2_is_SorA ||
                !c1_is_special && !c2_is_special ) {
          return 0;
        } else if( c1.symbol == Symbol.JACK && c2.symbol != Symbol.JACK ||
                c1_is_special && !c2_is_special ) {
          return 1;
        }
        return -1;
      }
    };
    PriorityQueue<Card> pc = new PriorityQueue<>(cardSymbolComparator);
    for( Card c : hand ) {
      if( state.isAllowed(c) ) {
        pc.add(c);
      }
    }
    return pc.size() > 0 ? pc.peek() : null;
  }

  @Override
  Move ask(MauMauable state) {
    //System.out.println(state);
    //System.out.println("you have the cards: " + hand);
    Card proposal = null;
    // do we have a playable 7

    if( (proposal = playableSevens(state)) != null ) {
      return new Move(proposal, null);
    }
    proposal = bestPlayableCard(state);
    if( proposal != null && proposal.symbol == Symbol.JACK ) {
      return new Move(proposal, chooseColor());
    }
    return new Move(proposal, null);
  }

  @Override
  Color chooseColor() {
    Set<Color> colors_avail = new HashSet<>();
    for( var c : hand ) {
      colors_avail.add(c.color);
    }
    return Color.values()[rng.nextInt(Color.values().length)];
  }
}

public class Cards {
  public static void main(String[] args) {
    Game g = new Game(new Player[] {
            new ComputerPlayerBetter("Computer1"),
            new ComputerPlayer("Computer2"),
            new ComputerPlayer("Computer3")},
            new MauMauExt());
    g.start();
    System.out.println(g.winner.getName() + " has won.");
  }
}
