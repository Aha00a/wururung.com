package jobs;

import common.CommonInit;
import common.basic.databases.DatabaseManager;
import common.basic.facades.jsons.gson.JsonEngineGson;
import common.play1.logs.LoggerPlay;
import common.play1.utils.JobUtil;
import play.db.DB;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import siena.Id;

import java.sql.Connection;

@OnApplicationStart
public class JobOnApplicationStart extends Job {

    public void doJob() {
        CommonInit.init(new LoggerPlay(), true, new JsonEngineGson());

        initDatabaseManager();
        initDatabase();

        JobUtil.runAsync(new JobHourly());
    }

    private void initDatabaseManager() {
        DatabaseManager.initialize(new DatabaseManager.IProvider() {
            @Override
            public Connection getConnection() {
                return DB.getConnection();
            }

            @Override
            public Class getKeyAnnotation() {
                return Id.class;
            }
        });
    }

    private void initDatabase() {


    }

}