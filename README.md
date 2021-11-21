# pin-simplifier
DISCLAIMER: I have found the Lunar internship just a day before its closing date, and sadly have no option but to deliver a buggy program. 

At first I misunderstood the task and thought that on each line you start at 5 again; Next day I reworked it according to the task.
I made a test for it based on the input that was provided as an example, it successfully passed it. 

But then, when I decided to test with larger inputs, I found out that I had another false assumption.

I tried to optimise the input based on redundant steps because in real programs
this "finger moving" on the numpad can be a costly operation,
and implemented two counters for Vertical and Horizontal moving (if you go U the counter increments, when D it decrements; same with horizontal).

So based on this assumption, the input of LUUUUUUUDD would give me 1, as there are more U's, but it needs to be 7. 

I will fix it as well till Friday, after my uni tests, but now I have to leave it as is, of which I am NOT proud of :( 
