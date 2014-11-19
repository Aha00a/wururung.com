package models;

import siena.NotNull;
import siena.embed.Embedded;

import java.util.List;

public abstract class ClanWar extends ModelAutoIncrement {
    @NotNull
    String clanNameEnemy;

    @Embedded
    public List<String> listMemberUs;

    @Embedded
    public List<String> listMemberEnemy;

}
