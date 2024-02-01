# Decide
The purpose of this project is to implement a *Launch Interceptor Program*.

By combining *planar data points*, parameters, *Launch Interceptor Conditions* (LIC’s), a *Logical Connector Matrix* (LCM), and a *Preliminary Unlocking Vector* (PUM), the `Decide()` method determines whether or not to launch. For full implementation details, see [this](decide.pdf).

## How to run
This project uses Java.

### Main program
The entrypoint to this program is `LaunchInterceptor.java`. You can run the program with:

```bash
javac src/*.java
java src.LaunchInterceptor
```

### Run tests
We use junit 4 for our tests. Inside VS Code, click the green run/play button next to each test.

## Statement of contributions
For more details, go to issues and sort by assignee.

### Marcus Alström
* Wrote unit tests for LIC 1 and 2.
* Implemented LIC 2, 9 and 13.
* Wrote GeometryUtils and refactored LaunchInterceptor to use it.
* Wrote test cases for the Decide program.

### Oliver Lindgren
* Wrote unit tests for LIC 13 and 14.
* Implemented LIC 6, 11, and 12.
* Translated my old c++ point class into the one used in this project.
* Implemented the logic to calculate the PUM.

### Marcus Nilszén
* Wrote unit tests for LIC 3, 5, 7 and 11.
* Implemented LIC 1, 4, 5 and 8.
* Implemented FUV and CMV.
* Wrote most of the documentation (README files).

### Noak Jönsson
* Wrote unit tests for LIC 0, 2, 10 and 12.
* Implemented LIC 3, 10 and 14.
* Fixed multiple bugs in LIC tests.
* Wrote triangle area method.

### Leo Bosch
* Wrote unit tests for LIC 4, 6 and 9.
* Implemented LIC 0 and 7.
* Wrote some unit tests for Decide() method.

<!-- ## Our way of working (Essence standard) -->