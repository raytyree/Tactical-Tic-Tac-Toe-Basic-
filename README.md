# Tactical Tic Tac Toe-Basic-
A Tic Tac Toe game featuring regular Tic Tac Toe and a more complex game, Tactical Tic Tac Toe.

Made using JavaSE 16

NOTE: Since Windows CMD does not accept ANSI colors by default, you will need to change the setting manually.


## Version 0.1
- Has multiplayer
- Missing an AI 
## Setting up ANSI Colors in Terminal
### Open the Registry Editor
Win+R -> Type "regedit" in the prompt
### Updating the Registry
Navigate to "HKEY_CURRENT_USER\Console" in the Registry Editor.

*(NOTE: If you have a "VirtualTerminalLevel" REG_DWORD set its value to 1 and ignore the last steps)*

Right click in the folder and do "New-> DWORD(32-bit) Value".

On the new DWORD set the name to "VirtualTerminalLevel" and the value to 1.
