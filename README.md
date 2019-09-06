# pdf-page
Pdf Document Operation Cli  tool

```
java -jar target/pdf-page-1.0.0-standalone.jar
Usage: pdf-page <image-url|image-dir>
       pdf-page <source> <OPTIONS> <PARAM> [..]
OPTIONS:
 -h,--head   Head with images/pages.
             pdf-page <source> -h <image-url|image-dir>
 -t,--tail   Tail up images/pages
             pdf-page <source> -t <image-url|image-dir|pages.pdf>
 -d,--delete Delete page.
             pdf-page <source> -d <page-range>
             Page range support 1,2 [3-5], -1 mean last page.
 -p,--page  Print the page number on each page.
             pdf-page <source> -p <startPage> <fontSize> <offsetBottom>
 -m,--mask   Mask specific area on page.
             pdf-page <source> -m <page-number> <pos> <size>
 -r,--ruler  Draw a ruler on page.
             pdf-page <source> -r <page-number>
 -T,--text   Draw text on page.
             pdf-page <source> -T <page-number> <posx> <posy> <text> <LEFT|CENTER|RIGHT> <size> [family]
```
