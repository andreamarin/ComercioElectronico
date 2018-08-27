set cb=%cd%\example/hello

java -Djava.rmi.server.codebase=file:%cb% example.hello.Server