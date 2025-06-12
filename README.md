# Programação Com Acesso a Banco de Dados

Exemplos da disciplina Programação Com Acesso a Banco de Dados (2025) para o curso Técnico Integrado em Informática do Campus IFRN de São Gonçalo do Amarante.

## Acesso ao Servidor MySQL do LADIR

O servidor MySQL está disponível em uma VM na rede interna do campus. A ideia é que cada aluno e professor possa usar essa instância de forma remota, evitando instalar um servidor MySQL em cada máquina dos laboratórios. Use os dados abaixo para acesso.

- **Endereço**: `10.225.0.4`
- **Porta**: `3306`
- **Usuário**: `sua matrícula`
- **Senha**: `sua matrícula+último nome em letras minúsculas`

A senha padrão é formada pela `matrícula`, o sinal de `+` e o `último nome do usuário em letras minúsculas`, por exemplo, se o nome do usuário é `Maria João Pinto` e sua matrícula é `123456`, então sua senha padrão de acesso será `123456+pinto`. O usuário pode mudar sua senha quando fizer acesso remoto usando o comando:
```
ALTER USER 'sua_matricula'@'%' IDENTIFIED BY 'nova_senha';
```

Cada usuário tem permissão para criar e remover bancos de dados cujo nome começa com sua matrícula seguida de um `_`. Por exemplo, o usuário de matrícula `123456` tem permissão para criar bancos de dados que comecem com o nome `123456_`, como `123456_lista_01` ou `123456_prova_final`, e assim por diante.
