# Programação com Acesso a Banco de Dados 2023

Este repositório está em progresso e possui os arquivos de código-fonte desenvolvidos no ano letivo 2023 para a disciplina Programação com Acesso a Banco de Dados, do curso Técnico Integrado em Informática, do Campus IFRN de São Gonçalo do Amarante.

## ⚠️ Atenção ⚠️

O servidor MySQL do LADIR-SGA, ao qual este leia-me se refere a seguir, é um servidor compartilhado e que deve ser usado apenas para desenvolvimento e testes, nunca para um ambiente de produção ou para armazenar dados confidenciais.

## Acesso ao Servidor MySQL do LADIR-SGA

O servidor MySQL está disponível em uma VM na rede interna do campus. A ideia é que cada aluno e professor possa usar essa instância de forma remota, evitando instalar um servidor MySQL em cada máquina dos laboratórios. Use os dados abaixo para acesso.

- **Endereço**: `10.225.0.4`
- **Porta**: `3306`
- **Usuário**: `sua matrícula`
- **Senha**: `sua matrícula+último nome em letras minúsculas`

A senha padrão é formada pela `matrícula` e pelo `último nome do usuário em letras minúsculas`, por exemplo, se o nome do usuário é `Maria João Pinto` e sua matrícula é `123456`, então sua senha padrão de acesso será `123456+pinto`. O usuário pode mudar sua senha quando fizer acesso remoto usando o comando:
```
ALTER USER 'sua_matricula'@'%' IDENTIFIED BY 'nova_senha';
```

Cada usuário tem permissão para criar e remover bancos de dados cujo nome começa com sua matrícula seguida de um `_`. Por exemplo, o usuário de matrícula `123456` tem permissão para criar bancos de dados que comecem com o nome `123456_`, como `123456_lista_01` ou `123456_prova_final`, e assim por diante.
