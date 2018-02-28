call mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver="src\test\resources\drivers\chromedriver.exe"
call mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox
call mvn serenity:aggregate