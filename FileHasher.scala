package com.github.edgecaseberg

import java.nio.file._
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

case class FileHash(bytes: Array[Byte], hashString: String) {
		override def equals(obj: Any) = obj match {
			case that: FileHash => this.hashString == that.hashString
			case _ => false
		}
}

object FileHash {
	def apply(fPath: String) : FileHash = {
		val path = Paths.get(fPath)
		val messageDigest = MessageDigest.getInstance("MD5")
		messageDigest.update(Files.readAllBytes(path))
		val digest = messageDigest.digest()
		val stringHash = DatatypeConverter.printHexBinary(digest)
		FileHash(digest, stringHash)
	}
}
