# Unix System Programming lab Termworks

You can copy your file and press on EDIT and then paste

learn vi editor commands to read/write the lab termworks in this cheatsheet
https://atmos.albany.edu/daes/atmclasses/atm350/vi_cheat_sheet.pdf

common vi commands:
to create a vi file use:
	$ vi filename.c
1. important: to jump on to different modes, use Esc key
	by default vi editor will be in command mode
to bring it to write mode
	press 'i'
to save the file, press Esc then type
	:wq
or	ZZ
to exit the editor without saving the file, press Esc then type
	:q!
to undo, press Esc then press
	'u' to  undo last change
	'U' to undo all changes on line

or 

mkdir dir_name
cd dir_name
touch filename.c
//edit using gedit
gedit <filename>

or
you can paste this code in your terminal and
instead of tw*.c, you can type whichever the termwork you want 
eg: instead of tw*.c you can type tw5.c and the file will be downloaded in the directory you have chosen
wget -r -nH --cut-dirs=5 -nc ftp://software:software@10.10.1.12//Software/Fedora/USP/tw*.c











