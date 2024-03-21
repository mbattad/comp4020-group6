# Group 6: The Conversational Partner

## Build and run

### Prerequisites

You will need:
- Ant build system installed
- [Ant VS Code extension](https://marketplace.visualstudio.com/items?itemName=nickheap.vscode-ant) installed
- [jsch .jar file](https://mvnrepository.com/artifact/com.jcraft/jsch) downloaded and placed in `/.ant/lib`
- Vstone Sota robot connected to the same network as your computer
- IP address of Sota

### Build

1. Clean the `bin` folder by running the build target "clean" with Ant.
2. Compile the source files by running the build target "compile" with Ant.
3. Copy the repository to Sota by running the build target "send" with Ant.
> This step will prompt you to enter input. Use "Edison" as the platform and the Sota's IP address:
```sh
setconf:
    [input] Select Pratform? ([Rpi], Edison)
Edison
    [input] Please enter ip: [192.168.1.]
// your IP here…
```

### Run

4. Log into a Sota console using `ssh`.
5. Navigate to `bin` in the Sota console.
6. Run `java_run.sh` with your target program as the argument.
> If you don't have permission to run `java_run.sh`, run the command `chmod u+x java_run.sh`.

## Project structure
The actions Sota can perform are organized in the `actions` package.

## Authors
- Farah Hegazi
- Lucas Berzuk
- Mia Battad
- Nouran Bileha
- Zachary de Graeve