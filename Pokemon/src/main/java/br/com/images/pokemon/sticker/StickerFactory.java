package br.com.images.pokemon.sticker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerFactory {

    public void generateSticker(String url, String archiveName){
        try{
            InputStream inputStream = new URL(url).openStream();
            BufferedImage originalImage = ImageIO.read(inputStream);

            createImage(originalImage, archiveName);
        }catch(IOException exception){
            throw new RuntimeException(exception);
        }

    }

    public void createImage(BufferedImage originalImage, String archiveName){

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 20;

        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        String formatedName = archiveName.substring(0,1).toUpperCase() + archiveName.substring(1);
        //Configurando a fonte do texto
        fontConfigure(graphics, width, newHeight, 10, formatedName);

        //Criando diretorio para salvar imagem
        createDirectory(newImage, formatedName);
    }

    public static void fontConfigure(Graphics2D graphics, int width, int newHeight, int fontSize, String text){
        //Configurar Fonte
        var font = new Font(Font.DIALOG_INPUT, Font.BOLD, fontSize);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //Escrever uma frase cômica na imagem
        graphics.drawString(text, width-(width*0.7f), newHeight-10);
    }

    //Função que verifica se o diretorio "saida" já está criado
    public static void createDirectory(BufferedImage image, String archiveName){
        File file = new File("src/main/java/br/com/images/pokemon/saida/");
        try{
            if(file.exists()) {
                ImageIO.write(image, "png", new File("src/main/java/br/com/images/pokemon/saida/" + archiveName+".png"));
            }else {
                file.mkdir();
                ImageIO.write(image, "png", new File("src/main/java/br/com/images/pokemon/saida/"+archiveName+".png"));
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
