Historically, during the typewriter days, there used to be two buttons,
Return (`\r`) and Enter (`\n`). Using `\r`, the carriage goes back to the
left until it hits a stop point. And using `\n` moves the roller upwards by
one line.

`\r` was also used in old Macs (before OSX) and currently it's still being
used in Windows alongside the line feed (`\r\n`) as the newline character.

You should only use `\n` in modern systems, and the runtime will translate it
to appropriate newline character.
The only reason to use `\r` in modern systems is if you're using a
[character terminal](https://en.wikipedia.org/wiki/Computer_terminal#Character-oriented_terminal)
(or if you're emulating it) and want a new line to overwrite the current line.
If you've seen ASCII progress bars in terminals, that's done using this.
