classpath=".\
:../bin/*\
:../lib/*\
:/home/vstone/lib/*\
:/home/vstone/vstonemagic/*\
"

echo "javac -target 1.8 -encoding utf-8 -classpath $classpath $1"
javac -encoding -target 1.8 utf-8 -classpath  "$classpath" $1

