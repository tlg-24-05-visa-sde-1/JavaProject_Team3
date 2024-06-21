
javac -d classes -classpath "lib\*" src\com\jbm\connect4\client\*.java src\com\jbm\connect4\controller\*.java src\com\jbm\connect4\model\*.java src\com\jbm\connect4\view\*.java



jar --create --file connect4-1.0.jar -C classes .



