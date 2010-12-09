Please note that jvncsender uses:

- http://www.tightvnc.com/
- http://www.jcraft.com/jsch/ (as it is used by tightvnc)


Usage from the commandline: 

usage: java -jar jvncsender.jar [-list] [-help] -host <hostname> -port <port> -text <text> [-password <password>] [-wait <seconds>]
 -help                  print this message
 -host <hostname>       hostname or ip-address to send it to
 -list                  list keymappings
 -password <password>   password to use
 -port <port>           port to connect to f.i. 5900
 -text <text>           text to send, (can be use multiple times)
 -wait <seconds>        seconds to wait in between sending different texts (default=1s)

text can also take special keys f.i. like "linux ks=ks.cfg<RETURN>"
use -list options to see all keymappings

