package com.unizar.phytoscheme.processes.hive;

import static com.unizar.phytoscheme.processes.common_methods.Common.executeExternalProcess;
import static com.unizar.phytoscheme.processes.common_methods.Common.fichero_configuracion;
import static com.unizar.phytoscheme.processes.common_methods.Common.getProperty;

/**
 * Created by catalin on 9/11/17.
 */
public class Hive {


    // Actualiza la base de datos Hive
    public static void insertIntoHiveTable(String hadoop_dir, String hive_database, String hive_table) {
        System.out.println("Insertando datos de " + hadoop_dir + " a la tabla de Hive " + hive_table + ".");
        executeExternalProcess(getProperty("hive_executable_23") +
            " -hiveconf IMPORT_FROM_DIR="+ hadoop_dir +
            " -hiveconf IMPORT_INTO_TABLE=" + hive_database + "."+ hive_table +
            " -f Scripts/Hive_Scripts/load_data_into_hive.hql");
    }

    // Hace un drop a la tabla table de Hive
    public static void dropHiveTable(String hive_database, String hive_table) {
        System.out.println("Borrando la tabla " + hive_table + " de Hive");
        executeExternalProcess(getProperty("hive_executable_23") +
            " -hiveconf HIVE_TABLE=" + hive_database + "."+ hive_table +
            " -f Scripts/Hive_Scripts/dropHiveTable.hql");
    }

    // Crea la tabla de Hive sustancia_activa_europa
    public static void createActiveSubstanceEuropeHiveTable() {
        System.out.println("Creando la tabla sustancia_activa_europa en Hive");
        executeExternalProcess(getProperty("hive_executable_23") +
            " -f Scripts/Hive_Scripts/createSustanciaActivaEuropa.hql");
    }

    // Crea la tabla de Hive fitosanitario_con_id
    public static void createFitosanitarioSpainHiveTable() {
        System.out.println("Creando la tabla fitosanitario_con_id en Hive");
        executeExternalProcess(getProperty("hive_executable_23") +
            " -f Scripts/Hive_Scripts/create_fitosanitarios_table.hql");
    }
}
