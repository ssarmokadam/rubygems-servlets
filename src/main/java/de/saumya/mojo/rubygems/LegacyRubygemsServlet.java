package de.saumya.mojo.rubygems;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.nexus.ruby.FileType;
import org.sonatype.nexus.ruby.GemArtifactFile;
import org.sonatype.nexus.ruby.RubygemsFile;

public class LegacyRubygemsServlet extends RubygemsServlet
{
    private static final long serialVersionUID = 2441264980328145654L;

    protected void handle( HttpServletRequest req, HttpServletResponse resp, RubygemsFile file ) 
            throws IOException, ServletException
    {
        if ( file.type() == FileType.GEM_ARTIFACT )
        {
            resp.sendRedirect( "https://rubygems.org/gems/" + ((GemArtifactFile) file ).gem( null ).filename() + ".gem" );
        }
        else
        {
            super.handle( req, resp, file );
        }
    }
}