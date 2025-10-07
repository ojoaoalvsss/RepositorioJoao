package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<ContaBancaria> contas = new ArrayList<>();

    // Adiciona uma conta à lista
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    // Salva todas as contas no Excel
    public void salvarContasExcel(String caminhoArquivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Contas Bancárias");

        // Cabeçalho
        Row cabecalho = sheet.createRow(0);
        cabecalho.createCell(0).setCellValue("Número da Conta");
        cabecalho.createCell(1).setCellValue("Titular");
        cabecalho.createCell(2).setCellValue("Saldo");

        // Preenche as linhas
        int rowNum = 1;
        for (ContaBancaria conta : contas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(conta.getNumeroConta());
            row.createCell(1).setCellValue(conta.getTitular());
            row.createCell(2).setCellValue(conta.getSaldo());
        }

        // Ajusta a largura das colunas
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Salva no arquivo físico
        try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Planilha salva com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
