# Unix System Programming ftp guide

### Note: Replace the "\*" in tw*.cpp to download the desired file

### local download from inside the network

wget -r -nH --cut-dirs=5 -nc ftp://software:software@10.10.1.12//Software/Fedora/USP/tw*.c

### Global download from outside the network

wget -r -nH --cut-dirs=5 -nc ftp://software:software@210.212.207.12//Software/Fedora/USP/tw*.c

## Example: To download tw3.c locally

wget -r -nH --cut-dirs=5 -nc ftp://software:software@10.10.1.12//Software/Fedora/USP/tw3.c

## Example: To download tw3.c globally

wget -r -nH --cut-dirs=5 -nc ftp://software:software@210.212.207.12//Software/Fedora/USP/tw3.c













