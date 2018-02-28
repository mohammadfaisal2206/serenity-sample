call mvn verify -Dcontext=edge -Dwebdriver.driver=edge -Dwebdriver.edge.driver="src\test\resources\drivers\MicrosoftWebDriver.exe"
call mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox
call mvn serenity:aggregate