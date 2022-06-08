import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AnimalsTask extends DefaultTask {
    def myFile = 'fileNotExist.txt'

    @TaskAction
    def file(){
        def animalsFile = project.file('buildSrc/src/main/resources/' + myFile)
        animalsFile.parentFile.mkdirs()
        animalsFile.write('Some animals')
        println 'Just open: ' + animalsFile.path
    }
}
