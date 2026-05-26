# Plataforma de Monitoramento Espacial - GS POO Java

Projeto desenvolvido para a Global Solution de Programação Orientada a Objetos em Java.

## Conceitos aplicados

- Classe abstrata: `ComponenteEspacial` e `SistemaPropulsao`
- Interface: `Sensor`
- Encapsulamento: `DadosMissao`
- Herança: `PropulsaoQuimica`, `PropulsaoEletrica` e `ModuloHabitat`
- Polimorfismo: uso das listas `List<Sensor>` e `List<SistemaPropulsao>`
- Menu interativo no console
- Sistema de alertas com níveis: ATENÇÃO, ALERTA e CRÍTICO

## Como executar

No terminal, dentro da pasta do projeto:

```bash
javac *.java
java SistemaMonitoramento
```

## Código de acesso padrão

Para consultar ou alterar coordenadas protegidas, use:

```text
1234
```

## Estrutura

```text
projeto-espacial/
├── ComponenteEspacial.java
├── ModuloHabitat.java
├── Sensor.java
├── DadosMissao.java
├── SistemaPropulsao.java
├── PropulsaoQuimica.java
├── PropulsaoEletrica.java
├── SensorTemperatura.java
├── SensorPressao.java
├── SensorRadiacao.java
└── SistemaMonitoramento.java
```
