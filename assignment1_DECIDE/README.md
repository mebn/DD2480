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

<!-- ## Statement of contributions -->

## Our way of working (Essence standard)
We would classify our way of working as being *In Use*. We have decided on style guidelines when it comes to (squash and merge) commits, branch and pull request naming. We all know how to use issues for our use cases. All group members have access to the necessary tools required to participate. One thing that could be improved is the way we distrubute work amoung us. Right now we have a first-come, first-served approch, where each member picks the issues to work on. Thoses with more time can then work more, so the distrubute of work might become unbalanced.