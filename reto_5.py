#NO BORRAR LAS IMPORTACIONES QUE ENCUENTRAN A CONTINUACIÓN. LA FUNCIÓN QUE VA A 
#COMPLETAR NO REQUERIRÁ DE PARÁMETROS DE ENTRADA

#LOS MÓDULOS csv Y json ESTÁN ADJUNTOS POR DEFECTO EN LAS VERSIONES MÁS RECIENTES 
#DE PYTHON (3.x). ASEGÚRESE DE QUE LA VERSIÓN DE PYTHON EN LA QUE USTED HA ESTADO 
#EJECUTANDO SU PROPUESTA DE SOLUCIÓN CONTIENE DICHO MÓDULO
import pandas as pd
import csv
import json
def clima():
    
    #A PARTIR DE ACÁ PUEDE ADJUNTAR SU PROPUESTA DE SOLUCIÓN.REMÍTASE AL ENUNCIADO 
    #PARA MÁS DETALLES.
    
    #RECUERDE QUE SU PROPUESTA DEBE ACCEDER A UN ARCHIVO LLAMADO  "data.csv" 
    #(EL ARCHIVO ESTÁ EN ESTA PLATAFORMA), REALIZAR CÁLCULOS EN CADA FILA CON 
    #DOS DATOS ESPECÍFICOS Y LLEVAR LOS RESULTADOS A UN OBJETO JSON QUE CONTENDRÁ 
    #CINCO LISTAS DE DOS PROMEDIOS CADA UNA. ESTE ES EL OBJETO QUE DEBE RETORNAR.
    
    #SU SOLUCIÓN TAMBIÉN DEBE ESTAR EN CAPACIDAD DE CREAR UN ARCHIVO CSV
    #QUE DEBE LLAMARSE "data_nuevo.csv" A PARTIR DE "data.csv" CON LAS 
    #ESPECIFICACIONES INDICADAS EN EL ENUNCIADO
    
    df = pd.read_csv('data.csv')
    lista_temp = []
    lista_press = []
    for i in range(1,6):
        prom = df[df.location == i].mean()
        lista_temp.append(round(prom['temperature'],1))
        lista_press.append(round(prom['pressure'],1))
    serie_loc = df.location
    serie_temp = df.temperature
    serie_press = df.pressure
    above_avg_temp = []
    above_avg_pres = []
    for i in range(0,1000):
        if serie_loc[i] == 1:
            if serie_temp[i] > lista_temp[0]:
                above_avg_temp.append('SI')
            elif serie_temp[i] < lista_temp[0]:
                above_avg_temp.append('NO')
            elif serie_temp[i] == lista_temp[0]:
                above_avg_temp.append('IGUAL')
            
            if serie_press[i] > lista_press[0]:
                above_avg_pres.append('SI')
            elif serie_press[i] < lista_press[0]:
                above_avg_pres.append('NO')
            elif serie_press[i] == lista_press[0]:
                above_avg_pres.append('IGUAL')
        if serie_loc[i] == 2:
            if serie_temp[i] > lista_temp[1]:
                above_avg_temp.append('SI')
            elif serie_temp[i] < lista_temp[1]:
                above_avg_temp.append('NO')
            elif serie_temp[i] == lista_temp[1]:
                above_avg_temp.append('IGUAL')
            
            if serie_press[i] > lista_press[1]:
                above_avg_pres.append('SI')
            elif serie_press[i] < lista_press[1]:
                above_avg_pres.append('NO')
            elif serie_press[i] == lista_press[1]:
                above_avg_pres.append('IGUAL')
        if serie_loc[i] == 3:
            if serie_temp[i] > lista_temp[2]:
                above_avg_temp.append('SI')
            elif serie_temp[i] < lista_temp[2]:
                above_avg_temp.append('NO')
            elif serie_temp[i] == lista_temp[2]:
                above_avg_temp.append('IGUAL')
            
            if serie_press[i] > lista_press[2]:
                above_avg_pres.append('SI')
            elif serie_press[i] < lista_press[2]:
                above_avg_pres.append('NO')
            elif serie_press[i] == lista_press[2]:
                above_avg_pres.append('IGUAL')
        if serie_loc[i] == 4:
            if serie_temp[i] > lista_temp[3]:
                above_avg_temp.append('SI')
            elif serie_temp[i] < lista_temp[3]:
                above_avg_temp.append('NO')
            elif serie_temp[i] == lista_temp[3]:
                above_avg_temp.append('IGUAL')
            
            if serie_press[i] > lista_press[3]:
                above_avg_pres.append('SI')
            elif serie_press[i] < lista_press[3]:
                above_avg_pres.append('NO')
            elif serie_press[i] == lista_press[3]:
                above_avg_pres.append('IGUAL')
        if serie_loc[i] == 5:
            if serie_temp[i] > lista_temp[4]:
                above_avg_temp.append('SI')
            elif serie_temp[i] < lista_temp[4]:
                above_avg_temp.append('NO')
            elif serie_temp[i] == lista_temp[4]:
                above_avg_temp.append('IGUAL')
            
            if serie_press[i] > lista_press[4]:
                above_avg_pres.append('SI')
            elif serie_press[i] < lista_press[4]:
                above_avg_pres.append('NO')
            elif serie_press[i] == lista_press[4]:
                above_avg_pres.append('IGUAL')
    df['above_avg_temp'] = above_avg_temp
    df['above_avg_pres'] = above_avg_pres
    dict_json = {}
    for i in range(1,6):
        lista_dict = [lista_temp[i-1],lista_press[i-1]]
        dict_json[i] = lista_dict
    with open('datos.json','w') as archivo:
        datos = json.dump(dict_json, archivo)
    del(df['id'])
    lista_indices = list(range(1,1001))
    df.index = lista_indices
    df.index.name = 'id'
    df.to_csv('data_nuevo.csv')

clima()
