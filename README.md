### Group Members:

- Darrius Art
  - Contributions
    - Completed part 1 and part 2 of the project
- Asher Bordelon
  - Contributions
    - Worked on part 3 of the project
- Jack Corson
  - Contributions
    - Worked on part 3 of the project
- Gustavo Coloma
  - Contributions
    - Worked on part 3 of the project

### Issues:

- We implemented Several `ExpTy transExp(Exp e)` and `ExpTy and transDec(Decl d)` related methods located in the `Semant.java` File
- We had issues with the Parser not functioning properly, hindering our ability to test.
  - Replacing the Parser files with a newer set caused numerous compile-time errors that we were unable to resolve.
- We were unable to complete implementation of the following:
  - `FunctionDeclaration`
      - Ran out of time, `transTy`
  - `StructDeclaration`
      - Ran out of time, `transTy`
  - `FuncExpression`
      - Ran out of time, `transTy`
  - `CallExp`
    - Couldn't find the argument list for the function func in `CallExp`. So `CallExp` can't check whether or not the arguments align with func declaration.
- Additionally, we were unable to write our `transTy` methods within `Semant.java`, which stopped our completion of 3/4 above.
- As far as we are aware, the rest of the implementations should be functional or mostly functional within `Semant.java`.