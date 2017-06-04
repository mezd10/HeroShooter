abstract class TypeEnemy {

    int type;
    int rank;

    TypeEnemy(int type, int rank) {
        this.type = type;
        this.rank = rank;
    }

    abstract void enemyCreate();
}

