# umtDorobatAntoniaFlavia

Am rezolvat problema în două moduri, iar cele două rezolvări se află pe branch-urile Var1 și Var2. Ambele rezolvări sunt în Java.

Varianta1 (aflată pe branch-ul Var1) oferă o complexitate de timp bună, făcându-se aproximativ 3 * 1440 * n pași, unde unde n este numărul de intervale în care cele două persoane sunt ocupate. Totuși, complexitatea de spațiu este relativ mare, deoarece am folosit doi vectori de numere întregi de dimensiunea numărului de minute dintr-o zi (1440 minute). Consider că acesta este un compromis acceptabil și că varianta1 este mult mai eficientă decât varianta2, deoarece are timp liniar, favorabil pentru un n foarte mare.

Varianta2 (aflată pe branch-ul Var2) folosește o sortare (metoda sort() aplicată pe tipul List din Java). Știm că o sortare eficientă are o complexitate Theta(n*Log(n)), unde n este numărul de intervale în care cele două persoane sunt ocupate (în total, pentru ambele persoane). De asemenea, se fac adăugări în lista de Pair-uri și o parcurgere integrală a acestei liste de dimensiune n. 

Pentru un n destul de mare, prima variantă este mult mai eficientă. Dacă rezolvăm inecuația: 
                                                            
                                                            n + n *Log(n) < 3 * 1440 * n  
                                                            împărțim la n 
                                                            1+Log(n)   < 3 * 1440
                                                               Log(n)  < 3 * 1440-1
                                                               Log(n)  < 4319 
                                                               Cum 2^14 = 4096, iar 2^13 = 8192, observăm că inegalitatea are loc doar pentru n < 13, 
                                                               ceea ce înseamnă ca ar trebui sa avem cel mult 12 intervale în datele de input 
                                                               ca varianta2 să fie mai eficientă din punct de vedere al complexității de timp.  
                                                               
Desigur, varianta2 a fost mai ușor de implementat și, pentru unele date de intrare, are o complexitate de spațiu mult mai bună. 
Așadar, alegerea variantei cele mai bune dintre cele două depinde de obiectivele programatorului. :)
                                                                                                                
Se poate observa că în ambele variante se obțin aceleași rezultate.
