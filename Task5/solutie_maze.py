class Nod:
    def __init__(self, parent=None, position=None):
        self.parent = parent
        self.position = position
        self.g = 0
        self.h = 0
        self.f = 0
        self.perete_spart = False

    def __eq__(self, other):

        return (self.position == other.position) and (
            self.perete_spart == other.perete_spart
        )


def solution(map):

    poz_plecare = (0, 0)
    poz_finala = (len(map) - 1, len(map[0]) - 1)

    start = Nod(parent=None, position=poz_plecare)
    final = Nod(parent=None, position=poz_finala)

    de_vizitat = []
    vizitat = []

    de_vizitat.append(start)

    while len(de_vizitat):

        nod_curent = de_vizitat[0]

        for nod in de_vizitat:
            if nod_curent.f > nod.f:
                nod_curent = nod
            elif nod_curent.f == nod.f and nod_curent.h > nod.h:
                nod_curent = nod

        de_vizitat.remove(nod_curent)

        vizitat.append(nod_curent)

        if nod_curent.position == final.position:
            return nod_curent.g + 1

        copii = []

        for pozitie in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            pozitie_noua = (
                nod_curent.position[0] + pozitie[0],
                nod_curent.position[1] + pozitie[1],
            )
            if (
                pozitie_noua[0] < 0
                or pozitie_noua[0] >= len(map)
                or pozitie_noua[1] < 0
                or pozitie_noua[1] >= len(map[0])
            ):
                continue

            if map[pozitie_noua[0]][pozitie_noua[1]] == 1:

                if nod_curent.perete_spart:
                    continue
                else:
                    provizoriu = Nod(nod_curent, pozitie_noua)
                    provizoriu.perete_spart = True

                    if provizoriu not in vizitat:
                        copii.append(provizoriu)
                    continue

            provizoriu = Nod(nod_curent, pozitie_noua)
            provizoriu.perete_spart = nod_curent.perete_spart

            if provizoriu not in vizitat:
                copii.append(provizoriu)

        for copil in copii:
            copil.g = nod_curent.g + 1
            copil.h = abs(poz_finala[0] - copil.position[0]) + abs(
                poz_finala[1] - copil.position[1]
            )
            copil.f = copil.g + copil.h

            for nod_inca_nevizitat in de_vizitat:
                if nod_inca_nevizitat == copil:
                    if nod_inca_nevizitat.g > copil.g:
                        indice = de_vizitat.index(nod_inca_nevizitat)
                        de_vizitat[indice] = copil
                        continue
            de_vizitat.append(copil)


print(
    solution(
        [
            [0, 0, 0, 0, 0, 0],
            [1, 1, 1, 1, 0, 1],
            [0, 0, 0, 0, 0, 0],
            [0, 0, 1, 1, 1, 1],
            [1, 1, 1, 1, 1, 1],
            [0, 0, 0, 0, 0, 0],
        ]
    )
)

print(
    solution(
        [
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 1, 1, 1, 1, 1, 1, 1],
            [0, 1, 1, 0, 1, 0, 1, 0],
            [0, 1, 0, 0, 0, 0, 1, 0],
            [0, 1, 0, 1, 0, 1, 1, 0],
            [0, 0, 0, 1, 1, 1, 1, 0],
        ]
    )
)
