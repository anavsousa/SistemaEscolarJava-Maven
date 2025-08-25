package br.com.sistemaescola;

import br.com.sistemaescola.Model.*;
import br.com.sistemaescola.DAO.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        TurmaDAO turmaDAO = new TurmaDAO();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DiretorDAO diretorDAO = new DiretorDAO();
        while (true) {
            System.out.println("\n==============================");
            System.out.println("   SISTEMA ESCOLAR JAVA MAVEN  ");
            System.out.println("==============================");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Cadastrar Professor");
            System.out.println("5. Listar Professores");
            System.out.println("6. Remover Professor");
            System.out.println("7. Cadastrar Turma");
            System.out.println("8. Listar Turmas");
            System.out.println("9. Remover Turma");
            System.out.println("10. Cadastrar Disciplina");
            System.out.println("11. Listar Disciplinas");
            System.out.println("12. Remover Disciplina");
            System.out.println("13. Cadastrar Avaliação");
            System.out.println("14. Listar Avaliações");
            System.out.println("15. Remover Avaliação");
            System.out.println("16. Consultar Boletim do Aluno");
            System.out.println("17. Cadastrar Mensalidade");
            System.out.println("18. Listar Mensalidades");
            System.out.println("19. Remover Mensalidade");
            System.out.println("20. Cadastrar Funcionário");
            System.out.println("21. Listar Funcionários");
            System.out.println("22. Remover Funcionário");
            System.out.println("23. Cadastrar Diretor");
            System.out.println("24. Listar Diretores");
            System.out.println("25. Remover Diretor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("--- Cadastro de Aluno ---");
                    Aluno aluno = new Aluno();
                    System.out.print("Nome: "); aluno.setNome(scanner.nextLine());
                    System.out.print("Matrícula: "); aluno.setMatricula(scanner.nextLine());
                    Endereco endereco = new Endereco();
                    System.out.print("Rua: "); endereco.setRua(scanner.nextLine());
                    System.out.print("Número: "); endereco.setNumero(scanner.nextLine());
                    System.out.print("Bairro: "); endereco.setBairro(scanner.nextLine());
                    System.out.print("Cidade: "); endereco.setCidade(scanner.nextLine());
                    System.out.print("Estado: "); endereco.setEstado(scanner.nextLine());
                    aluno.setEndereco(endereco);
                    alunoDAO.salvar(aluno);
                    System.out.println("Aluno salvo com sucesso!");
                    break;
                case 2:
                    System.out.println("--- Lista de Alunos ---");
                    List<Aluno> alunos = alunoDAO.listarTodos();
                    for (Aluno a : alunos) {
                        System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Matrícula: " + a.getMatricula());
                    }
                    break;
                case 3:
                    System.out.print("ID do aluno para remover: ");
                    Long idAluno = scanner.nextLong();
                    scanner.nextLine();
                    alunoDAO.remover(idAluno);
                    System.out.println("Aluno removido!");
                    break;
                case 4:
                    System.out.println("--- Cadastro de Professor ---");
                    Professor professor = new Professor();
                    System.out.print("Nome: "); professor.setNome(scanner.nextLine());
                    System.out.print("Disciplina Principal: "); professor.setDisciplinaPrincipal(scanner.nextLine());
                    Endereco endProf = new Endereco();
                    System.out.print("Rua: "); endProf.setRua(scanner.nextLine());
                    System.out.print("Número: "); endProf.setNumero(scanner.nextLine());
                    System.out.print("Bairro: "); endProf.setBairro(scanner.nextLine());
                    System.out.print("Cidade: "); endProf.setCidade(scanner.nextLine());
                    System.out.print("Estado: "); endProf.setEstado(scanner.nextLine());
                    professor.setEndereco(endProf);
                    professorDAO.salvar(professor);
                    System.out.println("Professor salvo com sucesso!");
                    break;
                case 5:
                    System.out.println("--- Lista de Professores ---");
                    List<Professor> professores = professorDAO.listarTodos();
                    for (Professor p : professores) {
                        System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Disciplina: " + p.getDisciplinaPrincipal());
                    }
                    break;
                case 6:
                    System.out.print("ID do professor para remover: ");
                    Long idProf = scanner.nextLong();
                    scanner.nextLine();
                    professorDAO.remover(idProf);
                    System.out.println("Professor removido!");
                    break;
                case 7:
                    System.out.println("--- Cadastro de Turma ---");
                    Turma turma = new Turma();
                    System.out.print("Nome da Turma: "); turma.setNome(scanner.nextLine());
                    turmaDAO.salvar(turma);
                    System.out.println("Turma salva com sucesso!");
                    break;
                case 8:
                    System.out.println("--- Lista de Turmas ---");
                    List<Turma> turmas = turmaDAO.listarTodos();
                    for (Turma t : turmas) {
                        System.out.println("ID: " + t.getId() + " | Nome: " + t.getNome());
                    }
                    break;
                case 9:
                    System.out.print("ID da turma para remover: ");
                    Long idTurma = scanner.nextLong();
                    scanner.nextLine();
                    turmaDAO.remover(idTurma);
                    System.out.println("Turma removida!");
                    break;
                case 10:
                    System.out.println("--- Cadastro de Disciplina ---");
                    Disciplina disciplina = new Disciplina();
                    System.out.print("Nome da Disciplina: "); disciplina.setNome(scanner.nextLine());
                    System.out.print("Carga Horária: "); disciplina.setCargaHoraria(scanner.nextInt());
                    scanner.nextLine();
                    disciplinaDAO.salvar(disciplina);
                    System.out.println("Disciplina salva com sucesso!");
                    break;
                case 11:
                    System.out.println("--- Lista de Disciplinas ---");
                    List<Disciplina> disciplinas = disciplinaDAO.listarTodos();
                    for (Disciplina d : disciplinas) {
                        System.out.println("ID: " + d.getId() + " | Nome: " + d.getNome() + " | Carga Horária: " + d.getCargaHoraria());
                    }
                    break;
                case 12:
                    System.out.print("ID da disciplina para remover: ");
                    Long idDisc = scanner.nextLong();
                    scanner.nextLine();
                    disciplinaDAO.remover(idDisc);
                    System.out.println("Disciplina removida!");
                    break;
                case 13:
                    System.out.println("--- Cadastro de Avaliação ---");
                    Avaliacao avaliacao = new Avaliacao();
                    System.out.print("Tipo: "); avaliacao.setTipo(scanner.nextLine());
                    System.out.print("Nota: "); avaliacao.setNota(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.print("ID do Aluno: "); Long idAlunoAva = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoAva = alunoDAO.buscarPorId(idAlunoAva);
                    avaliacao.setAluno(alunoAva);
                    System.out.print("ID da Disciplina: "); Long idDiscAva = scanner.nextLong();
                    scanner.nextLine();
                    Disciplina discAva = disciplinaDAO.buscarPorId(idDiscAva);
                    avaliacao.setDisciplina(discAva);
                    avaliacaoDAO.salvar(avaliacao);
                    System.out.println("Avaliação salva com sucesso!");
                    break;
                case 14:
                    System.out.println("--- Lista de Avaliações ---");
                    List<Avaliacao> avaliacoes = avaliacaoDAO.listarTodos();
                    for (Avaliacao a : avaliacoes) {
                        System.out.println("ID: " + a.getId() + " | Tipo: " + a.getTipo() + " | Nota: " + a.getNota() + " | Aluno: " + (a.getAluno() != null ? a.getAluno().getNome() : "") + " | Disciplina: " + (a.getDisciplina() != null ? a.getDisciplina().getNome() : ""));
                    }
                    break;
                case 15:
                    System.out.print("ID da avaliação para remover: ");
                    Long idAva = scanner.nextLong();
                    scanner.nextLine();
                    avaliacaoDAO.remover(idAva);
                    System.out.println("Avaliação removida!");
                    break;
                case 16:
                    System.out.print("ID do aluno para consultar boletim: ");
                    Long idAlunoBol = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoBol = alunoDAO.buscarPorId(idAlunoBol);
                    List<Avaliacao> avaliacoesBol = avaliacaoDAO.listarTodos();
                    System.out.println("--- Boletim do Aluno ---");
                    System.out.println("Aluno: " + (alunoBol != null ? alunoBol.getNome() : "Não encontrado"));
                    for (Avaliacao a : avaliacoesBol) {
                        if (a.getAluno() != null && a.getAluno().getId().equals(idAlunoBol)) {
                            System.out.println("Disciplina: " + (a.getDisciplina() != null ? a.getDisciplina().getNome() : "") + " | Tipo: " + a.getTipo() + " | Nota: " + a.getNota());
                        }
                    }
                    break;
                case 17:
                    System.out.println("--- Cadastro de Mensalidade ---");
                    Mensalidade mensalidade = new Mensalidade();
                    System.out.print("Valor: "); mensalidade.setValor(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.print("Status do Pagamento: "); mensalidade.setStatusPagamento(scanner.nextLine());
                    System.out.print("ID do Aluno: "); Long idAlunoMen = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoMen = alunoDAO.buscarPorId(idAlunoMen);
                    mensalidade.setAluno(alunoMen);
                    mensalidadeDAO.salvar(mensalidade);
                    System.out.println("Mensalidade salva com sucesso!");
                    break;
                case 18:
                    System.out.println("--- Lista de Mensalidades ---");
                    List<Mensalidade> mensalidades = mensalidadeDAO.listarTodos();
                    for (Mensalidade m : mensalidades) {
                        System.out.println("ID: " + m.getId() + " | Valor: " + m.getValor() + " | Status: " + m.getStatusPagamento() + " | Aluno: " + (m.getAluno() != null ? m.getAluno().getNome() : ""));
                    }
                    break;
                case 19:
                    System.out.print("ID da mensalidade para remover: ");
                    Long idMen = scanner.nextLong();
                    scanner.nextLine();
                    mensalidadeDAO.remover(idMen);
                    System.out.println("Mensalidade removida!");
                    break;
                case 20:
                    System.out.println("--- Cadastro de Funcionário ---");
                    Funcionario funcionario = new Funcionario();
                    System.out.print("Nome: "); funcionario.setNome(scanner.nextLine());
                    System.out.print("Cargo: "); funcionario.setCargo(scanner.nextLine());
                    Endereco endFunc = new Endereco();
                    System.out.print("Rua: "); endFunc.setRua(scanner.nextLine());
                    System.out.print("Número: "); endFunc.setNumero(scanner.nextLine());
                    System.out.print("Bairro: "); endFunc.setBairro(scanner.nextLine());
                    System.out.print("Cidade: "); endFunc.setCidade(scanner.nextLine());
                    System.out.print("Estado: "); endFunc.setEstado(scanner.nextLine());
                    funcionario.setEndereco(endFunc);
                    funcionarioDAO.salvar(funcionario);
                    System.out.println("Funcionário salvo com sucesso!");
                    break;
                case 21:
                    System.out.println("--- Lista de Funcionários ---");
                    List<Funcionario> funcionarios = funcionarioDAO.listarTodos();
                    for (Funcionario f : funcionarios) {
                        System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
                    }
                    break;
                case 22:
                    System.out.print("ID do funcionário para remover: ");
                    Long idFunc = scanner.nextLong();
                    scanner.nextLine();
                    funcionarioDAO.remover(idFunc);
                    System.out.println("Funcionário removido!");
                    break;
                case 23:
                    System.out.println("--- Cadastro de Diretor ---");
                    Diretor diretor = new Diretor();
                    System.out.print("Nome: "); diretor.setNome(scanner.nextLine());
                    Endereco endDir = new Endereco();
                    System.out.print("Rua: "); endDir.setRua(scanner.nextLine());
                    System.out.print("Número: "); endDir.setNumero(scanner.nextLine());
                    System.out.print("Bairro: "); endDir.setBairro(scanner.nextLine());
                    System.out.print("Cidade: "); endDir.setCidade(scanner.nextLine());
                    System.out.print("Estado: "); endDir.setEstado(scanner.nextLine());
                    diretor.setEndereco(endDir);
                    diretorDAO.salvar(diretor);
                    System.out.println("Diretor salvo com sucesso!");
                    break;
                case 24:
                    System.out.println("--- Lista de Diretores ---");
                    List<Diretor> diretores = diretorDAO.listarTodos();
                    for (Diretor d : diretores) {
                        System.out.println("ID: " + d.getId() + " | Nome: " + d.getNome());
                    }
                    break;
                case 25:
                    System.out.print("ID do diretor para remover: ");
                    Long idDir = scanner.nextLong();
                    scanner.nextLine();
                    diretorDAO.remover(idDir);
                    System.out.println("Diretor removido!");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
