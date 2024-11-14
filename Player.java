public class Player {
    private int health;
    private final int strength;
    private final int attack;
    private final String name;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(this.health - damage, 0);
    }
}