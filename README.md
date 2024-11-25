This cutting-edge BDD (Behavior-Driven Development) Cucumber framework is built from the ground up using the latest technologies to ensure scalability, maintainability, and ease of use. It comes equipped with the following implementations:

1) Selenium – Web automation for seamless browser interaction.
2) Cucumber – For BDD, allowing clear and concise feature documentation.
3) TestNG – To manage test execution and reporting.
4) Page Object Model (POM) – Organized code structure for reusable page components.
5) Parallel Execution – Faster test runs with multi-threaded capabilities.
6) Extent Reports – Rich and interactive reporting with detailed test outcomes.
7) Cloud-based Cucumber Report Publishing – Share test reports in the cloud.
8) Cucumber Reports (HTML, JSON) – Comprehensive output formats for better analysis.
9) TestNG Runner – For running tests seamlessly with TestNG.
10) Failure TestNG Runner – Retry failed tests automatically.
11) Custom Exceptions – Robust error handling tailored for the framework.
12) Dependency Injection with Pico-container – Improved test modularity and object management.
13) AssertJ for Assertions – Fluent and readable assertions for test validation.
14) Log4j2 – Advanced logging mechanism for better traceability.
15) TestNG XML Execution – Structured configuration for test suite execution.
16) Command Line Execution – Flexible test execution via command line.
17) BrowserStack Integration – Cross-browser testing in the cloud with BrowserStack.
18) CI/CD Ready – Designed for continuous integration and delivery pipelines.


Setup:

Clone the repository: git clone https://github.com/AmolWangate/WTWSeleniumProject.git
Install dependencies: mvn clean install -DskipTests
Running Tests • Using Maven: mvn test -Dbrowser=chrome -Dmode=local • Using TestNG: Right-click on the testng.xml file in your IDE and select "Run". • Running on BrowserStack: Configure BrowserStack credentials and desired capabilities in the remotecaps.properties and change the mode to browserstack in envconfig.properties
