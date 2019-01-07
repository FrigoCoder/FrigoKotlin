package trace

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.WritableImage
import java.io.File
import javax.imageio.ImageIO

class Image(val xs: Int, val ys: Int) {

    private val pixels = Array(xs) { Array(ys) { Color.Black } }

    operator fun get(x: Int, y: Int) = pixels[x][y]
    operator fun set(x: Int, y: Int, color: Color) {
        pixels[x][y] = color
    }

    fun save(filename: String) {
        val image = WritableImage(xs, ys)
        val writer = image.pixelWriter
        for (x in 0 until xs) {
            for (y in 0 until ys) {
                val color = this[x, y]
                writer.setColor(x, y, javafx.scene.paint.Color(color.r, color.g, color.b, 1.0))
            }
        }
        val bufferedImage = SwingFXUtils.fromFXImage(image, null)
        val file = File(filename)
        ImageIO.write(bufferedImage, file.extension, file)
    }

}
