# TDD Exercises

Projeto desenvolvido em Java com Maven, JUnit 5 e JaCoCo para os exercícios de TDD.

## Tecnologias

- Java 17
- Maven
- JUnit 5
- JaCoCo

## Repositório

URL do repositório Git: https://github.com/LuizHRFerreira/Lab-5-Junit

## Build e execução dos testes

Para compilar o projeto, executar todos os testes e gerar o relatório de cobertura:

```bash
mvn clean test
```

O JaCoCo está configurado no `pom.xml` para gerar o relatório durante a fase de testes.

Relatórios gerados:

- Testes: `target/surefire-reports`
- Cobertura HTML: `target/site/jacoco/index.html`
- Cobertura CSV: `target/site/jacoco/jacoco.csv`

Caso o Maven indique problema com `JAVA_HOME`, configure a variável para um JDK 17 válido antes de executar os testes.

Exemplo no PowerShell:

```powershell
$env:JAVA_HOME="C:\caminho\para\jdk-17"
$env:Path="$env:JAVA_HOME\bin;$env:Path"
mvn clean test
```

## Evidência da execução

Execução local validada:

```txt
Tests run: 58, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Exercício 1 - Triângulo

Classe implementada: `com.example.tdd.triangle.Triangle`

Teste: `com.example.tdd.triangle.TriangleTest`

Casos cobertos:

- Triângulo escaleno válido
- Triângulo isósceles válido
- Triângulo equilátero válido
- Três permutações para isósceles válido
- Valor zero em cada posição
- Valor negativo em cada posição
- Soma de dois lados igual ao terceiro lado, com todas as permutações
- Soma de dois lados menor que o terceiro lado, com todas as permutações
- Três lados iguais a zero

Evidência dos testes:

```txt
Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
```

Evidência de cobertura JaCoCo:

| Classe | Linhas | Branches | Métodos |
| --- | ---: | ---: | ---: |
| Triangle | 10/10 - 100% | 22/22 - 100% | 2/2 - 100% |

## Exercício 2 - Person e Email

Classes implementadas:

- `com.example.tdd.person.Person`
- `com.example.tdd.person.Email`
- `com.example.tdd.person.PersonDAO`

Teste: `com.example.tdd.person.PersonDAOTest`

Validações cobertas:

- Nome com ao menos duas partes
- Nome composto apenas por letras
- Idade no intervalo [1, 200]
- Pessoa com pelo menos um email
- Email no formato `_____@____._____`, com cada parte preenchida
- Objetos e valores nulos em cenários inválidos

Evidência dos testes:

```txt
Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
```

Evidência de cobertura JaCoCo:

| Classe | Linhas | Branches | Métodos |
| --- | ---: | ---: | ---: |
| Person | 13/13 - 100% | N/A | 9/9 - 100% |
| Email | 11/11 - 100% | N/A | 6/6 - 100% |
| PersonDAO | 22/22 - 100% | 24/24 - 100% | 4/4 - 100% |

## Exercício 3 - Calculadora salarial

Classes implementadas:

- `com.example.tdd.salary.Employee`
- `com.example.tdd.salary.Role`
- `com.example.tdd.salary.SalaryCalculator`

Teste: `com.example.tdd.salary.SalaryCalculatorTest`

Regras cobertas:

- DESENVOLVEDOR com salário maior ou igual a 3000: desconto de 20%
- DESENVOLVEDOR com salário menor que 3000: desconto de 10%
- DBA com salário maior ou igual a 2000: desconto de 25%
- DBA com salário menor que 2000: desconto de 15%
- TESTADOR com salário maior ou igual a 2000: desconto de 25%
- TESTADOR com salário menor que 2000: desconto de 15%
- GERENTE com salário maior ou igual a 5000: desconto de 30%
- GERENTE com salário menor que 5000: desconto de 20%

Evidência dos testes:

```txt
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
```

Evidência de cobertura JaCoCo:

| Classe | Linhas | Branches | Métodos |
| --- | ---: | ---: | ---: |
| Employee | 10/10 - 100% | N/A | 5/5 - 100% |
| Role | 5/5 - 100% | N/A | 1/1 - 100% |
| SalaryCalculator | 6/6 - 100% | 9/9 - 100% | 2/2 - 100% |
