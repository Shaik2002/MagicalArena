public class Arena {
    private final Player playerA;
    private final Player playerB;
    private final Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public Player startBattle() {
        Player attacker = playerA.getHealth() <= playerB.getHealth() ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;

        while (attacker.isAlive() && defender.isAlive()) {
            executeTurn(attacker, defender);
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        
        return attacker.isAlive() ? attacker : defender;
    }

    private void executeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attackRoll * attacker.getAttack();
        int defendStrength = defendRoll * defender.getStrength();
        int netDamage = Math.max(attackDamage - defendStrength, 0);

        defender.reduceHealth(netDamage);

        System.out.println(attacker.getName() + " attacks " + defender.getName() +
                " for " + netDamage + " damage. " + defender.getName() + " health: " + defender.getHealth());
    }
}