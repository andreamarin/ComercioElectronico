set path=C:\Program Files\Java\jdk1.8.0_171\bin;%path%
set classpath=.;C:\Program Files\Java\jdk1.8.0_171;%classpath%

FOR /L %%k IN (1,1,4) DO start "Proceso "%%k cjk.bat


