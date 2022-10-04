import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { ScheduleModule } from '@nestjs/schedule';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ClientPublicViewModule } from './api/clientpublicview/clientPublicView.module';
import { ClientStatusCodeModule } from './datasync/clientstatuscode/clientStatusCode.module';
import { ClientTypeCodeModule } from './datasync/clienttypecode/clientTypeCode.module';
import { ForestClientModule } from './datasync/forestclient/forestClient.module';

@Module({
  imports: [
    ConfigModule.forRoot(),
    TypeOrmModule.forRoot({
      name: 'oracledb',
      type: 'oracle',
      host: process.env.ORACLEDB_HOST || 'localhost',
      port: Number(process.env.ORACLEDB_PORT || 1521),
      serviceName: process.env.ORACLEDB_SERVICENAME,
      connectString: `(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCPS)(HOST=nrcdb03.bcgov)(PORT=${Number(
        process.env.ORACLEDB_PORT || 1521,
      )}))) (CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=FORTMP1.nrs.bcgov)))`,
      database: process.env.ORACLEDB_DATABASE || 'oracle',
      username: process.env.ORACLEDB_USER || 'oracle',
      password: process.env.ORACLEDB_PASSWORD,
      autoLoadEntities: true, // Auto load all entities registered by typeorm forFeature method.
      synchronize: false, // This changes the DB schema to match changes to entities, which we might not want.
      //logging: true
    }),
    TypeOrmModule.forRoot({
      name: 'postgresdb',
      type: 'postgres',
      host: process.env.POSTGRESQL_HOST || 'localhost',
      port: 5432,
      database: process.env.POSTGRESQL_DATABASE || 'postgres',
      username: process.env.POSTGRESQL_USER || 'postgres',
      password: process.env.POSTGRESQL_PASSWORD,
      autoLoadEntities: true,
      synchronize: false,
      //logging: true
    }),
    ScheduleModule.forRoot(),
    ForestClientModule,
    ClientStatusCodeModule,
    ClientTypeCodeModule,
    ClientPublicViewModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
