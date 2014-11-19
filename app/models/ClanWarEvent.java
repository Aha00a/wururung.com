package models;

public abstract class ClanWarEvent extends ModelAutoIncrement {
    public static enum Type {
        Attack,
        Defense
    }

    ClanWar clanWar;

    String member;
    String enemy;
    int percentDestroyed;
    int countStar;
    int countStarForClan;


}
