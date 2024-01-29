# DD2480
A software engineering course at KTH. Info about the course can be found [here](https://www.kth.se/student/kurser/kurs/DD2480?l=en).

## Naming conventions
### Branch
Name the branch after the issue number:
```
issue/{issue-number}
```

### Pull request
The title of the pull request should follow this structure:
```
Keyword: issue #{issue-number} {Short summary}
```

Keywords:
- `Add`: e.g. a new feature or test
- `Remove`: when removing something
- `Fix`: a bugfix
- `Doc`: when adding, removing or changing documentation
- `Refactor`: updating existing code and/or refactoring

Also, link the issue with the pull request. This can be done manually or by adding `closes #{issue-number}` in the description.

### Commits
#### Within a branch
No standard because we use `Squash & Merge` so each pull request shows as one commit in `main` branch.

However, you might want to use something like:
```
Keyword: {short summary of commit}
```

#### Merge pull request
This is the commit message that will show up in `main`. It should follow the same structure as a pull request, followed by `(#{branch-number})`.