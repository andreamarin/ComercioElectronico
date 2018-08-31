set path=C:\Program Files\Java\jdk1.8.0_181\bin;%path%
set classpath=.;C:\Program Files\Java\jdk1.8.0_181;%classpath%

FOR /L %%k IN (1,1,3) DO start "Proceso "%%k cjk.bat


