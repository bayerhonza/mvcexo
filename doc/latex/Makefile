.PHONY: mvcdoc.pdf all clean

all: mvcdoc.pdf

mvcdoc.pdf: mvcdoc.tex
	latexmk -pdf -pdflatex="pdflatex -interaction=nonstopmode" -use-make mvcdoc.tex
clean:
	latexmk -CA
