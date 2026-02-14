package practice.java_17_feature.Sealed_classes;

public sealed class Payment permits UPI, Card {
    /**
    * All permitted subclasses must be in the same module
      (or same package if no module)

    * Each subclass must choose ONE of these: final, sealed, non-sealed
    * <p>
    *Modifier	Meaning
    final	  - No further subclassing
    sealed	   -Controlled further
    non-sealed - Open again
    * <p>
    *
    * Why Java introduced sealed classes
     1️⃣ Safer design

     No accidental subclasses

    Business logic stays correct

    2️⃣ Better switch expressions

     Sealed classes + pattern matching = 🔥

     static double area(Shape s) {
     return switch (s) {
     case Circle c -> Math.PI * c.radius() * c.radius();
     case Rectangle r -> r.length() * r.width();
     case Square sq -> sq.side() * sq.side();
     };
     }
    * <p>
    * * */
}
