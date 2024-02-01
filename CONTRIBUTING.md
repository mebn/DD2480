# Contribution Guidelines
Please follow these guidelines before contributing to this project.

## Naming guidelines
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

Link the issue with the pull request. This can be done manually or by adding `closes #{issue-number}` in the description.

### Commits
#### Within a branch
No standard because we use `Squash & Merge` so each pull request shows as one commit in `main` branch.

However, you might want to use something like:
```
Keyword: {short summary of commit}
```

#### Merge pull request
This is the commit message that will show up in `main`. It should follow the same structure as a pull request, followed by `(#{branch-number})`.

### Code comments and documentation
Add documentation to all functions and methods you write. This includes unit tests.

Names of functions, variables, etc should be self-explanatory. Prefer this to comments describing the piece of code. An example:
```python
# don't
let x = "john"
# do
let first_name = "john"
```

## Unnecessary files/folders
Please don't include any unnecessary files and folders. You can update `.gitignore` to prevent it from getting pushed.

## Moving files/folders
If you want to move files or folders, please make sure to use `git mv` (or similar) to preserve git commit history.