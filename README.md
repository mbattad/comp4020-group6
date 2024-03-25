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

## Operating Sota
### Movement
The actions Sota can perform are organized in the `actions` package.

Once connected to Sota, run `./java_run.sh actions.ControlSota` to launch the operator program.

As the robot loads up, you will see some console output. Once you see the line `Ready to accept commands!`, you can begin giving commands.

The three commands are:
- `d`: move Sota to the default position (eyes blue, arms down)
- `i`: move Sota to the "incorrect" position (eyes red, hands on chest)
- `c`: move Sota to the "correct" position (eyes green, hands up)

To exit the program, either use a keyboard interrupt (`Ctrl+C`), or type `exit` twice.

### Voice
The `Voice Clips` directory contains Sota's pre-defined voice clips, organized by function. It is recommended to have a few open tabs with each category to quickly switch between clips.

- **Intro**: Phrases Sota says during start-up and between activities. For example, "Hello, my name is Sota," "Nice to meet you," "What would you like to do," etc.
- **Phrase_of_Day**: Each language's Phrase of the Day.
    - `phrase_XX`: The lead-in to the phrase, then the phrase in both languages.
    - `phrase_XX_translation`: Only the English translation of the phrase.
    - `fata_futin`/`ca_vaut_le_cout`/`otsukare`: Only the target language phrase, per language.
- **Feedback**: Phrases to congratulate or correct the user while learning flashcards or the Phrase of the Day.
- **Flashcards_XX**: The flashcard decks for each language. Play the English words before the target language words.
    - Play `fc_intro` at the beginning of each flashcard session.
    - Play `fc_intro2` after `fc_intro` when using the **detailed script**.
- **Conversations**: Lead-in to conversations.
    - When using the **detailed script**, use the clip corresponding to the user's difficulty level and target language.
        - BEGINNER: beginner
        - INTER: intermediate
        - ADV: advanced
    - Always play the `intro_change` clip regardless of the script. When using the **detailed script**, play this after the difficulty level introduction.

Some clips will have a two-letter suffix representing the language they are in.
- EN: English
- AB: Arabic
- FR: French
- JP: Japanese
If a clip has no suffix, it is in English by default.

## Authors
- Farah Hegazi
- Lucas Berzuk
- Mia Battad
- Nouran Bileha
- Zachary de Graeve