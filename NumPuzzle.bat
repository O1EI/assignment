:: ---------------------------------------------------------------------
:: JAP COURSE - SCRIPT
:: ASSIGNMENTS - CST8221 - Fall 2022
:: ---------------------------------------------------------------------
:: Begin of Script (Assignments - F22)
:: ---------------------------------------------------------------------
CLS
:: LOCAL VARIABLES ....................................................
SET SRCDIR=src
SET BINDIR=bin
SET BINOUT=puzzle-javac.out
SET BINERR=puzzle-javac.err
SET JARNAME=NumPuzzle.jar
SET JAROUT=puzzle-jar.out
SET JARERR=puzzle-jar.err
SET DOCDIR=doc
SET DOCPACK=puzzle
SET DOCOUT=puzzle-javadoc.out
SET DOCERR=puzzle-javadoc.err
SET MAINCLASSSRC=src/puzzle/NumPuzzle.java
SET MAINCLASSBIN=puzzle.NumPuzzle
@echo off
ECHO " _________________________________ "
ECHO "|    |  |  / \ \  \  /  / / \     |"
ECHO "|    |  | /   \ \  \/  / /   \    |"
ECHO "|    |  |/  _  \ \    / /  _  \   |"
ECHO "|  __|  |  / \  \ \  / /  / \  \  |"
ECHO "|  \____/_/   \__\ \/ /__/   \__\ |"
ECHO "|                                 |"
ECHO "| .. ALGONQUIN COLLEGE - 2022F .. |"
ECHO "|_________________________________|"
ECHO "                                   "
ECHO "[ASSIGNMENT SCRIPT ---------------]"

ECHO "1. Compiling ......................"
javac -Xlint -cp ".;%SRCDIR%" %MAINCLASSSRC% -d %BINDIR% > %BINOUT% 2> %BINERR%

:: ECHO "Running  ........................."
:: start java -cp ".;%BINDIR%;%JAVAFXDIR%/*" %MAINCLASSBIN%

ECHO "2. Creating Jar ..................."
cd bin
jar cvfe %JARNAME% %MAINCLASSBIN% . > %JAROUT% 2> %JARERR%

ECHO "3. Creating Javadoc ..............."
cd ..
javadoc -cp ".;%BINDIR%" -d %DOCDIR% -sourcepath %SRCDIR% -subpackages %DOCPACK% > %DOCOUT% 2> %DOCERR%

cd bin
ECHO "4. Running Jar ...................."
start java -jar %JARNAME%
cd ..

ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (Assignments - F22)
:: ---------------------------------------------------------------------