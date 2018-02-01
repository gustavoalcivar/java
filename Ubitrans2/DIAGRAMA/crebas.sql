/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     10/01/2014 21:21:44                          */
/*==============================================================*/


drop index PARADAS_PK;

drop table PARADAS;

drop index RELATIONSHIP_3_FK;

drop index RELATIONSHIP_2_FK;

drop index PARADA_RUTA_PK;

drop table PARADA_RUTA;

drop index RUTAS_PK;

drop table RUTAS;

drop index RELATIONSHIP_10_FK;

drop index R9_FK;

drop index TIEMPOS_PK;

drop table TIEMPOS;

drop index UNIDADES_PK;

drop table UNIDADES;

drop index R6_FK;

drop index R7_FK;

drop index UNIDAD_RUTA_PK;

drop table UNIDAD_RUTA;

drop index RELATIONSHIP_11_FK;

drop index VIAJES_PK;

drop table VIAJES;

/*==============================================================*/
/* Table: PARADAS                                               */
/*==============================================================*/
create table PARADAS (
   ID_PARADA            VARCHAR(10)          not null,
   NOMBRE_PARADA        VARCHAR(30)          not null,
   DISTANCIA            NUMERIC(5)           not null,
   DESCRIPCION_PARADA   VARCHAR(50)          null,
   constraint PK_PARADAS primary key (ID_PARADA)
);

/*==============================================================*/
/* Index: PARADAS_PK                                            */
/*==============================================================*/
create unique index PARADAS_PK on PARADAS (
ID_PARADA
);

/*==============================================================*/
/* Table: PARADA_RUTA                                           */
/*==============================================================*/
create table PARADA_RUTA (
   ID_PARADA_RUTA       VARCHAR(10)          not null,
   ID_PARADA            VARCHAR(10)          not null,
   ID_RUTA              VARCHAR(10)          not null,
   NUMERO_DE_PARADA     NUMERIC(2)           not null,
   constraint PK_PARADA_RUTA primary key (ID_PARADA_RUTA)
);

/*==============================================================*/
/* Index: PARADA_RUTA_PK                                        */
/*==============================================================*/
create unique index PARADA_RUTA_PK on PARADA_RUTA (
ID_PARADA_RUTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on PARADA_RUTA (
ID_RUTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on PARADA_RUTA (
ID_PARADA
);

/*==============================================================*/
/* Table: RUTAS                                                 */
/*==============================================================*/
create table RUTAS (
   ID_RUTA              VARCHAR(10)          not null,
   NOMBRE_RUTA          VARCHAR(30)          not null,
   DESCRIPCION_RUTA     VARCHAR(50)          null,
   constraint PK_RUTAS primary key (ID_RUTA)
);

/*==============================================================*/
/* Index: RUTAS_PK                                              */
/*==============================================================*/
create unique index RUTAS_PK on RUTAS (
ID_RUTA
);

/*==============================================================*/
/* Table: TIEMPOS                                               */
/*==============================================================*/
create table TIEMPOS (
   ID_TIEMPO            VARCHAR(10)          not null,
   ID_PARADA_RUTA       VARCHAR(10)          not null,
   ID_VIAJE             VARCHAR(10)          not null,
   TIEMPO               NUMERIC(4)           not null,
   constraint PK_TIEMPOS primary key (ID_TIEMPO)
);

/*==============================================================*/
/* Index: TIEMPOS_PK                                            */
/*==============================================================*/
create unique index TIEMPOS_PK on TIEMPOS (
ID_TIEMPO
);

/*==============================================================*/
/* Index: R9_FK                                                 */
/*==============================================================*/
create  index R9_FK on TIEMPOS (
ID_PARADA_RUTA
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on TIEMPOS (
ID_VIAJE
);

/*==============================================================*/
/* Table: UNIDADES                                              */
/*==============================================================*/
create table UNIDADES (
   ID_UNIDAD            VARCHAR(10)          not null,
   PLACA                VARCHAR(7)           null,
   CAPACIDAD            NUMERIC(2)           null,
   NUMERO_DE_UNIDAD     NUMERIC(4)           null,
   constraint PK_UNIDADES primary key (ID_UNIDAD)
);

/*==============================================================*/
/* Index: UNIDADES_PK                                           */
/*==============================================================*/
create unique index UNIDADES_PK on UNIDADES (
ID_UNIDAD
);

/*==============================================================*/
/* Table: UNIDAD_RUTA                                           */
/*==============================================================*/
create table UNIDAD_RUTA (
   ID_UNIDAD_RUTA       VARCHAR(10)          not null,
   ID_UNIDAD            VARCHAR(10)          not null,
   ID_RUTA              VARCHAR(10)          not null,
   FECHA_INICIO         DATE                 not null,
   FECHA_FIN            DATE                 not null,
   constraint PK_UNIDAD_RUTA primary key (ID_UNIDAD_RUTA)
);

/*==============================================================*/
/* Index: UNIDAD_RUTA_PK                                        */
/*==============================================================*/
create unique index UNIDAD_RUTA_PK on UNIDAD_RUTA (
ID_UNIDAD_RUTA
);

/*==============================================================*/
/* Index: R7_FK                                                 */
/*==============================================================*/
create  index R7_FK on UNIDAD_RUTA (
ID_UNIDAD
);

/*==============================================================*/
/* Index: R6_FK                                                 */
/*==============================================================*/
create  index R6_FK on UNIDAD_RUTA (
ID_RUTA
);

/*==============================================================*/
/* Table: VIAJES                                                */
/*==============================================================*/
create table VIAJES (
   ID_VIAJE             VARCHAR(10)          not null,
   ID_UNIDAD_RUTA       VARCHAR(10)          not null,
   FECHA_VIAJE          DATE                 not null,
   TIEMPO_SALIDA        NUMERIC(4)           not null,
   constraint PK_VIAJES primary key (ID_VIAJE)
);

/*==============================================================*/
/* Index: VIAJES_PK                                             */
/*==============================================================*/
create unique index VIAJES_PK on VIAJES (
ID_VIAJE
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_11_FK on VIAJES (
ID_UNIDAD_RUTA
);

alter table PARADA_RUTA
   add constraint FK_PARADA_R_RELATIONS_RUTAS foreign key (ID_RUTA)
      references RUTAS (ID_RUTA)
      on delete restrict on update restrict;

alter table PARADA_RUTA
   add constraint FK_PARADA_R_RELATIONS_PARADAS foreign key (ID_PARADA)
      references PARADAS (ID_PARADA)
      on delete restrict on update restrict;

alter table TIEMPOS
   add constraint FK_TIEMPOS_R9_PARADA_R foreign key (ID_PARADA_RUTA)
      references PARADA_RUTA (ID_PARADA_RUTA)
      on delete restrict on update restrict;

alter table TIEMPOS
   add constraint FK_TIEMPOS_RELATIONS_VIAJES foreign key (ID_VIAJE)
      references VIAJES (ID_VIAJE)
      on delete restrict on update restrict;

alter table UNIDAD_RUTA
   add constraint FK_UNIDAD_R_R6_RUTAS foreign key (ID_RUTA)
      references RUTAS (ID_RUTA)
      on delete restrict on update restrict;

alter table UNIDAD_RUTA
   add constraint FK_UNIDAD_R_R7_UNIDADES foreign key (ID_UNIDAD)
      references UNIDADES (ID_UNIDAD)
      on delete restrict on update restrict;

alter table VIAJES
   add constraint FK_VIAJES_RELATIONS_UNIDAD_R foreign key (ID_UNIDAD_RUTA)
      references UNIDAD_RUTA (ID_UNIDAD_RUTA)
      on delete restrict on update restrict;

