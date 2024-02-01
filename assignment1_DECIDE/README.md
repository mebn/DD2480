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
We classified our way of working as *In Use*. We had decided on style guidelines for commits, branches, and pull requests. Every pull request had to be reviewed before being merged. We used test-driven development, where the test and implementation were written by different people. All group members had access to the necessary tools required to participate. One thing that could have been improved was the way we distributed work among us. We had a first-come, first-served approach, where each member picked the issues to work on. Those with more time could then work more, making the distribution of work a little unbalanced. We could also have set up e.g. Maven to handle tests better.