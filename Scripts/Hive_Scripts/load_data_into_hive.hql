LOAD DATA INPATH ${hiveconf:IMPORT_FROM_DIR} OVERWRITE INTO TABLE ${hiveconf:IMPORT_INTO_TABLE};
