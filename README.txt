**WAR CARD GAME**
Group: Raquel Chu, Vanessa Gerber, Taylor Kulawik, and Bethany Salazar

**SOLID and GRASP Principles in our project:**
---------------------------
Grasp Principle
---------------------------
    Class: Game
    The Grasp principle is implemented with the polymorphism pattern in this class.
    Since, there are two variations for the game, the game is split into two types. One
    is *GameVar1* and the other *GameVar2*. That connect through the main interface *Game*.

    Class: Deck
    The Grasp principle is implemented with the Information Expert Pattern in this class.
    Since, the game requires a deck and the deck contains many cards. And each card has
    different numbers and names. The class *card* is broken down to two enumerations
    one of them is *suit* and the other *rank*. Which they describe deep down the cards.

    Class(es): Card, Deck, Player
    The GRASP principle present in these classes is the Creator Principle. These classes
    build the objects 'Deck','Card', and 'Player', as well as keep up with their
    respective values and changes.

---------------------------
Solid Principle
---------------------------
    Class: Player
    The SOLID principle present here is SRP or Single Responsibility Principle. This class has the sole
    responsibility of handling the PLAYER object. It handles all the hand movements and points for a specified
    PLAYER object.

    Class: Game (Interface)
    The SOLID principle present here is the Interface Segregation Principle. I marked it as the interface itself
    because the only other classes that implement this interface are Main, GameVar1, and GameVar2. No other
    classes implement the Game interface because it is not needed.
